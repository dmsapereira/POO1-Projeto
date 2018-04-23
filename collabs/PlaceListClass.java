package collabs;

import generics.ArrayClass;

public class PlaceListClass implements PlaceList {
	ArrayClass<PlaceClass> places;

	public PlaceListClass() {
		places = new ArrayClass<PlaceClass>();
	}

	@Override
	public boolean addPlace(String name, int cost) {
		// TODO Auto-generated method stub
		PlaceClass newPlace;
		if (alreadyExists(name))
			return false;
		newPlace = new PlaceClass(name, cost);
		places.insertLast(newPlace);
		return false;
	}

	@Override
	public PlaceClass getPlace(String name) {
		// TODO Auto-generated method stub
		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getName().equals(name))
				return places.get(i);
		}
		return null;
	}

	private boolean alreadyExists(String name) {
		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getName().equals(name))
				return true;
		}
		return false;
	}
}
