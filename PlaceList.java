import generics.Iterator;

public interface PlaceList {
	
	 boolean addPlace(String name, int cost);
	 
	 PlaceClass getPlace(String name);
	 
	 Iterator<PlaceClass> getPlaces();
	 
	 boolean alreadyExists(String name);
	 

}
