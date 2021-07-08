package main.api;

public interface Firefighter {

  /**
   * Get the firefighter's current location. Initially, the firefighter should be at the FireStation
   *
   * @return {@link CityNode} representing the firefighter's current location
   */
  CityNode getLocation();

  /**
   * Set the firefighter's new location.
   *
   * @param newLocation representing the firefighter's new location
   */
  void setLocation(CityNode newLocation);

  /**
   * Get the total distance traveled by this firefighter. Distances should be represented using TaxiCab
   * Geometry: https://en.wikipedia.org/wiki/Taxicab_geometry
   *
   * @return the total distance traveled by this firefighter
   */
  int distanceTraveled();

  /**
   * Update the total distance traveled by this firefighter
   *
   * @param distance to be added to the firefighter's total distance
   */
  void updateDistanceTraveled(int distance);
}
