package com.rest.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int bookingId;
	private String duration;
	private String resources;
	private String location;
	private String person;
	private String numberofRooms;
	private String checkout;
	private String checkin;
	private String email;
	private String designation;
	private String username;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getNumberofRooms() {
		return numberofRooms;
	}
	public void setNumberofRooms(String numberofRooms) {
		this.numberofRooms = numberofRooms;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Customer [bookingId=" + bookingId + ", duration=" + duration + ", resources=" + resources
				+ ", location=" + location + ", person=" + person + ", numberofRooms=" + numberofRooms + ", checkout="
				+ checkout + ", checkin=" + checkin + ", email=" + email + ", designation=" + designation
				+ ", username=" + username + "]";
	}
	
}
