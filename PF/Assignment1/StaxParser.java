import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaxParser {
	static final String VEHICLE = "vehicle";
	static final String CAR = "car";
	static final String BIKE = "bike";
	static final String MAKE = "make";
	static final String MODEL = "model";
	static final String ENGINEINCC = "engineInCC";
	static final String FUELCAPACITY = "fuelCapacity";
	static final String MILAGE = "milage";
	static final String PRICE = "price";
	static final String ROADTAX = "roadTax";
	static final String AC = "ac";
	static final String POWERSTERING = "powerStering";
	static final String ACCESSORYKIT = "accessoryKit";
	static final String SELFSTART = "selfStart";
	static final String HELMETPRICE = "helmetPrice";

	// @SuppressWarnings({ "unchecked", "null" })
	public List<Vehicle> readConfig(String configFile) {
		List<Vehicle> vehicleObjectList = new ArrayList<Vehicle>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Vehicle objVehicle = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart() == (CAR)) {
						objVehicle = new Car();
					} else if (startElement.getName().getLocalPart() == (BIKE)) {
						objVehicle = new Bike();
					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart()
								.equals(MAKE)) {
							event = eventReader.nextEvent();
							objVehicle.setMake(event.asCharacters().getData());
							continue;
						}
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(MODEL)) {
						event = eventReader.nextEvent();
						objVehicle.setModel(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ENGINEINCC)) {
						event = eventReader.nextEvent();
						objVehicle.setEngineInCC(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(FUELCAPACITY)) {
						event = eventReader.nextEvent();
						objVehicle.setFuelCapacity(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(MILAGE)) {
						event = eventReader.nextEvent();
						objVehicle.setMilage(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(PRICE)) {
						event = eventReader.nextEvent();
						objVehicle.setPrice(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ROADTAX)) {
						event = eventReader.nextEvent();
						objVehicle.setRoadTax(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(AC)) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setAC(Boolean.valueOf(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(POWERSTERING)) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setPowerSteering(Boolean
								.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ACCESSORYKIT)) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setAccessoryKit(Boolean
								.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(SELFSTART)) {
						event = eventReader.nextEvent();
						((Bike) objVehicle).setSelfStart(Boolean.valueOf(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(HELMETPRICE)) {
						event = eventReader.nextEvent();
						((Bike) objVehicle).setHelmetPrice(Integer
								.parseInt(event.asCharacters().getData()));
						continue;
					}

					// vehicleObjectList.add(objVehicle);
				}
				// If we reach the end of a vehicle element, we add it to the
				// list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (CAR)) // || if (
																		// endElement.getName().getLocalPart()
																		// ==
																		// (Bike)
																		// )
					{
						vehicleObjectList.add(((Car) objVehicle));
					} else if (endElement.getName().getLocalPart() == (BIKE))
						vehicleObjectList.add(((Bike) objVehicle));
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return vehicleObjectList;
	}

}
