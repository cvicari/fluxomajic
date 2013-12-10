Fluxomajic
=======

Fluxomajic is a GeoServer plugin developed as a new pluggable SLD geometry transformation that renders the state of flows related to linestring and their associated information (i.e.: traffic state). It takes the following input parameters:

- Linestring collection
- Offset
- Width
- Drive side
- Number of quadrants
- ENDCAP style
- JOIN style

The output is a new polygonal geometry that follows the shape of the source linestrings directly in your WMS request:

![fluxomajic shaped traffic layer](https://raw.github.com/geobeyond/fluxomajic/master/img/fluxomajic.jpg "fluxomajic behavior")

## How to build

+ Make sure each dependency in the POM is aligned with the Geotools version used in your GeoServer. As an example version 9.0 for GeoServer 2.3:

```xml
	<dependency>
		<groupId>org.geotools</groupId>
		<artifactId>gt-xxx</artifactId>
		<version>9.0</version>
	</dependency>
```


+ Use Maven to build

```bash
	mvn clean install
```

## Credits
The module has been funded by [SISTeMA ITS](http://www.sistemaits.com/). Major credits go to [Michaël Michaud](http://geo.michaelm.free.fr/) and his development of [OpenJUMP](http://www.openjump.org/) offset curve plugin that has been ported to this module.
