import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import Planes.experimentalPlane;
import models.MilitaryType;

import java.util.*;
import java.util.stream.Collectors;


public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }


    public List<PassengerPlane> getPassengerPlanesList() {
        return (List<PassengerPlane>) planes.stream().filter(plane -> (plane instanceof PassengerPlane)).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return (List<MilitaryPlane>) planes.stream().filter(plane -> (plane instanceof MilitaryPlane)).collect(Collectors.toList());
    }

    public PassengerPlane getMaxPassengersCapacityPassengerPlane() {
        PassengerPlane passengerPlane = getPassengerPlanesList().get(0);
        return getPassengerPlanesList().stream().reduce(passengerPlane, (biggestPlane, nextPlane) -> (biggestPlane.getPassengersCapacity() > nextPlane.getPassengersCapacity()) ? biggestPlane : nextPlane);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().stream().filter(planes -> planes.getType() == MilitaryType.TRANSPORT).collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().stream().filter(planes -> planes.getType() == MilitaryType.BOMBER).collect(Collectors.toList());
    }

    public List<experimentalPlane> getExperimentalPlanes() {
        return (List<experimentalPlane>) planes.stream().filter(planes -> planes instanceof experimentalPlane).collect(Collectors.toList());
    }

    public Airport sortPlanesByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt((Plane planes) -> planes.getMaxFlightDistance()));
        return this;
    }

    public Airport sortPlanesByMaxSpeed() {
        planes.sort(Comparator.comparingInt((Plane planes) -> planes.getMaxSpeed()));
        return this;
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt((Plane planes) -> planes.getMaxLoadCapacity()));
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }


}
