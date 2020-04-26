package com.hnguyen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hnguyen.entities.City;
import com.hnguyen.services.CityService;

@Controller
@RequestMapping("/city")
public class CityController {

	private String viewDir = "city/";

	@Autowired
	private CityService cityService;

	@RequestMapping("/all")
	public String gettAllCities(Model model) {
		List<City> cities = this.cityService.getAllCities();
		model.addAttribute("cities", cities);
		return this.viewDir + "all_cities";
	}

	// Gets all cities that have the same name as "cityName".
	// http://localhost:8080/ExpensesTracking/city/?cityName=london
//	@RequestMapping(method = RequestMethod.GET)
//	public String getCitiesByName(@RequestParam String cityName, Model model) {
//		List<City> cities = this.cityService.getCityByName(cityName);
//		model.addAttribute("cities", cities);
//		model.addAttribute("cityName", cityName);
//		return this.viewDir + "cities_with_matching_name";
//	}

	// Gets all cities that have the same name as "cityName".
	@RequestMapping(value = "/name/{cityName}", method = RequestMethod.GET)
	public String getCitiesByName(@PathVariable String cityName, Model model) {
		List<City> cities = this.cityService.getCityByName(cityName);
		model.addAttribute("cities", cities);
		model.addAttribute("cityName", cityName);
		return this.viewDir + "cities_with_matching_name";
	}

	// Gets a city given its ID "cityID"
	// Since the cityID attribute in City class has type of integer.
	@RequestMapping(value = "/id/{cityID}", method = RequestMethod.GET)
	public String getCityByID(@PathVariable int cityID, Model model) {
		City city = this.cityService.getCityByCityID(cityID);
		// TODO Handles the case if no city is found.
		if (city == null) {
			return this.viewDir + "all_cities";
		}
		model.addAttribute("city", city);
		return this.viewDir + "city";
	}

	// Retrieves the city that contains the postal code "postalCode"
	@RequestMapping(value = "/postalcode/{postalCode}", method = RequestMethod.GET)
	public String getCityByPostalCode(@PathVariable String postalCode, Model model) {
		City city = this.cityService.getCityByPostalCode(postalCode);
		model.addAttribute("city", city);
		return this.viewDir + "city";
	}

	// Renders a form to add new city
	@RequestMapping(value = "/form/add", method = RequestMethod.GET)
	public String getCityAddForm(Model model) {
		City city = new City();
		model.addAttribute("city", city);
		return this.viewDir + "city_add_form";
	}

	// Route to handle new-city-saving & existing-city-updating requests
	@RequestMapping(value = "/form/save-city", method = RequestMethod.POST)
	public String saveCity(@ModelAttribute("city") City city) {
		this.cityService.saveCity(city);
		System.out.println("Save Route runs");
		// NOTE: for redirects, we need to use the machine route in those
		// @RequestMapping annotation.
		// NOT the file system route.
		return "redirect:/" + this.viewDir + "all";
	}

	// Displays a form to edit an existing city given its ID "cityID"
	@RequestMapping(value = "/form/edit/{cityID}", method = RequestMethod.GET)
	public String getCityEditForm(@PathVariable int cityID, Model model) {
		City city = this.cityService.getCityByCityID(cityID);
		model.addAttribute("city", city);
		model.addAttribute("isEdit", true);
		model.addAttribute("cityID", cityID);
		return this.viewDir + "city_add_form";
	}

	@RequestMapping(value = "/form/edit/{cityID}/save-city", method = { RequestMethod.PUT, RequestMethod.POST })
	public String updateCity(@ModelAttribute("city") City city) {
		this.cityService.saveCity(city);
		return "redirect:/" + this.viewDir + "all";
	}

	// Shows a form to delete a city with ID "cityID"

}
