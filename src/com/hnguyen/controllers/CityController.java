package com.hnguyen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hnguyen.entities.City;
import com.hnguyen.services.CityService;

@Controller
@RequestMapping("/cities")
public class CityController {

	private String viewDir = "city/";

	@Autowired
	private CityService cityService;

	@RequestMapping("/")
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
	@RequestMapping(value = "/{cityID}", method = RequestMethod.GET)
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
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getCityAddForm(Model model) {
		City city = new City();
		model.addAttribute("city", city);
		return this.viewDir + "city_form";
	}

	// Route to handle new-city-saving & existing-city-updating requests
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String saveCity(@ModelAttribute("city") City city) {
		this.cityService.saveCity(city);
		// NOTE: for redirects, we need to use the machine route in those
		// @RequestMapping annotation.
		// NOT the file system route.
		return "redirect:/" + "cities/";
	}

	// Displays a form to edit an existing city given its ID "cityID"
	@RequestMapping(value = "/{cityID}/edit", method = RequestMethod.GET)
	public String getCityEditForm(@PathVariable int cityID, Model model) {
		City city = this.cityService.getCityByCityID(cityID);
		model.addAttribute("city", city);
		model.addAttribute("isEdit", true);
		model.addAttribute("cityID", cityID);
		return this.viewDir + "city_form";
	}

	@RequestMapping(value = "/{cityID}/edit/execute", method = { RequestMethod.PUT, RequestMethod.POST })
	public String updateCity(@ModelAttribute("city") City city) {
		this.cityService.saveCity(city);
		return "redirect:/" + "cities/";
	}

	// Shows a form to confirm deleting a city with ID "cityID"
	@RequestMapping(value = "/{cityID}/delete", method = RequestMethod.GET)
	public String deleteCityConfirm(@PathVariable int cityID, Model model) {
		City city = this.cityService.getCityByCityID(cityID);
		model.addAttribute("city", city);
		return this.viewDir + "city_delete_confirm";
	}

	// Route to actually destroy the city.
	@RequestMapping(value = "/{cityID}/delete/execute", method = { RequestMethod.DELETE, RequestMethod.POST })
	public String deleteCity(@ModelAttribute("city") City city) {
		System.out.println("from controller: " + city.toString());
		this.cityService.deleteCity(city.getCityID());
		return "redirect:/" + "cities/";
	}

	// Redirects to the "cities/" route if user cancels delete process.
	@RequestMapping(value = "{cityID}/delete/cancel")
	public String cancelDeleteCity() {
		return "redirect:/" + "cities/";
	}

}
