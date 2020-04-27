package com.hnguyen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hnguyen.entities.City;
import com.hnguyen.entities.PostalCode;
import com.hnguyen.services.CityService;
import com.hnguyen.services.PostalCodeService;

@ControllerAdvice
@RequestMapping("/postalcodes")
public class PostalCodeController {

	private String viewDir = "postalcode/";

	@Autowired
	private PostalCodeService postalCodeService;

	@Autowired
	private CityService cityService;

	/**
	 * Retrieves all postal codes.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllPostalCodes(Model model) {
		List<PostalCode> postalCodes = this.postalCodeService.getAllPostalCodes();

		model.addAttribute("postalCodes", postalCodes);

		return this.viewDir + "all_postalcodes";
	}

	/**
	 * Gets all postal codes in a city given its ID "cityID".
	 */
	@RequestMapping(value = "/city/{cityID}", method = RequestMethod.GET)
	public String getAllPostalCodesInCity(@PathVariable int cityID, Model model) {
		List<PostalCode> postalCodes = this.postalCodeService.getAllPostalCodesInCity(cityID);
		// @TODO: handle the case "postalCodes" is empty.
		if (postalCodes.isEmpty()) {
			return "redirect:/" + "exceptions/generic";
		}

		model.addAttribute("postalCodes", postalCodes);

		return this.viewDir + "all_postalcodes";
	}

	/**
	 * Renders a form to add a new postal code belonging to existing cities. Embeds
	 * a link in the form to let user add a new city.
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String f(Model model) {
		PostalCode postalCode = new PostalCode();
		List<City> cities = this.cityService.getAllCities();

		model.addAttribute("postalCode", postalCode);
		model.addAttribute("cities", cities);

		return this.viewDir + "/postal_code_form";
	}

	/**
	 * Route to actually persist new postal code in DB. Redirects user to
	 * "postalcodes/" afterwards.
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String g(@ModelAttribute("postalCode") PostalCode postalCode) {
		String cityID_ = postalCode.getCity().getCityName();

		String postal_code_ = postalCode.getPostalCode();

		this.cityService.savePostalCode(cityID_, postal_code_, true);

		return "redirect:/" + "postalcodes/";
	}

	// Renders the postal code edit form.
	@RequestMapping(value = "/{postalCode}/edit", method = RequestMethod.GET)
	public String getPostalCodeEditForm(@PathVariable("postalCode") String postalCode_, Model model) {
		PostalCode postalCode = this.postalCodeService.getPostalCode(postalCode_);

		model.addAttribute("postalCode", postalCode);
		model.addAttribute("isEdit", true);

		List<City> cities = this.cityService.getAllCities();
		model.addAttribute("cities", cities);

		// Gets the city ID to render to select element.
		String cityID_ = "" + postalCode.getCity().getCityID();
		model.addAttribute("cityID", cityID_);

		return this.viewDir + "postal_code_form";
	}

	// Route to handle the update logic
	@RequestMapping(value = "/{postalCode}/edit/execute", method = { RequestMethod.PUT, RequestMethod.POST })
	public String updatePostalCode(@ModelAttribute("postalCode") PostalCode postalCode) {
		String postalCode_ = postalCode.getPostalCode(); // "3"

		String cityID_ = postalCode.getCity().getCityName(); // "N5X0E1"

		this.cityService.savePostalCode(cityID_, postalCode_, false);

		return "redirect:/" + "postalcodes/";
	}

	// Renders a form for user to confirm deletion.
	@RequestMapping(value = "/{postalCode}/delete", method = RequestMethod.GET)
	public String confirmDeletePostalCode(@PathVariable("postalCode") String postalCode_, Model model) {
		PostalCode postalCode = this.postalCodeService.getPostalCode(postalCode_);

		model.addAttribute("postalCode", postalCode);

		return this.viewDir + "postal_code_delete_confirm";
	}

	// Route to actually destroy the postal code.
	@RequestMapping(value = "/{postalCode}/delete/execute", method = { RequestMethod.DELETE, RequestMethod.POST })
	public String deletePostalCode(@ModelAttribute("postalCode") PostalCode postalCode) {
		try {
			this.postalCodeService.deletePostalCode(postalCode.getPostalCode());
		} catch (Exception ex) {
			ex.printStackTrace();
			// @TODO: there may be some customers, stores using this postal code, so
			// deletion fails.
			// @TODO: redirects user somewhere to tell him failure.
			return "redirect:/" + "exceptions/generic";
		}

		return "redirect:/" + "postalcodes/";
	}

	// Redirects to the "postalcodes/" route if user cancels delete process.
	@RequestMapping(value = "{postalCode}/delete/cancel")
	public String cancelDeletePostalCode() {
		return "redirect:/" + "postalcodes/";
	}

}
