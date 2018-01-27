# Airline

This application contains information about your airline company.

There are two classes for airplanes: single-engine and multi-engine. The count of engines are detected automatically by 'engines' field in data table.

### Data format
Data of airplanes constains in file `aircrafts.xlsx`.

| Airplane name | Number of engines | Total Capacity | Carrying Capacity | Flight Range | Fuel Consumption |
| :---: | :---: | :---: | :---: | :---: | :---: |
| String | int | double | double | double | double |

## Installation and running

Run this commands to install and run the application:

```
mvn install
mvn exec:java
```

## Testing

To run tests, type in terminal:

```
mvn test
```