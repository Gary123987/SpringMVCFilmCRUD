package com.skilldistillery.film.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
	private int filmId;
	private String title;
	private String desc;
	private int releaseYear; 
	private int langId;
	private int rentDur;
	private double rate;
	private int length;
	private double repCost;
	private String rating; 
	private String features;
	private List<Actor> actors;
	
	public Film() {}
	
	public Film(String title, int langId, int rentDur, double rate, double repCost) {
		this.title = title;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.repCost = repCost;
	}

	public Film(int filmId, String title, int langId, int rentDur, double rate, double repCost) {
		this.filmId = filmId;
		this.title = title;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.repCost = repCost;
	}

	public Film(String title, String desc, int releaseYear, int langId, int rentDur, double rate,
	int length, double repCost, String rating) {
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	public Film(int filmId, String title, String desc, int releaseYear, int langId, int rentDur, double rate,
			int length, double repCost, String rating) {
		this.filmId = filmId;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	public Film(int filmId, String title, String desc, int releaseYear, int langId, int rentDur, double rate,
			int length, double repCost, String rating, String features) {
		this.filmId = filmId;
		this.title = title;
		this.desc = desc;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getRentDur() {
		return rentDur;
	}

	public void setRentDur(int rentDur) {
		this.rentDur = rentDur;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getRepCost() {
		return repCost;
	}

	public void setRepCost(double repCost) {
		this.repCost = repCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}
	
	public List<Actor> getActors() {
		List<Actor> copy = new ArrayList<>(actors);
		return copy;
	}
	
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", desc=" + desc + ", releaseYear=" + releaseYear
				+ ", langId=" + langId + ", rentDur=" + rentDur + ", rate=" + rate + ", length=" + length + ", repCost="
				+ repCost + ", rating=" + rating + ", features=" + features + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, desc, features, filmId, langId, length, rate, rating, releaseYear, rentDur, repCost,
				title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(desc, other.desc)
				&& Objects.equals(features, other.features) && filmId == other.filmId && langId == other.langId
				&& length == other.length && Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear && rentDur == other.rentDur
				&& Double.doubleToLongBits(repCost) == Double.doubleToLongBits(other.repCost)
				&& Objects.equals(title, other.title);
	}

}