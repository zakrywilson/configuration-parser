# configuration-parser

A simple configuration file parser and container. 

## How to use

### Parsing a configuration file

Simply provide a config file name and the file will be parsed on creation of the object

```java
Config config = new Config("path/to/config/file");
```

The config file is now parsed and the elements are ready to be accessed

### Accessing elements

Obtain the String values by providing the element's name (e.g., the key)

```java
String configValue = config.getElement("configValueName");
```

Even parse the values into any primitive value

```java
byte   byteValue   = config.getElementAsByte("byteValue");
char   charValue   = config.getElementAsChar("charValue");
short  shortValue  = config.getElementAsShort("shortValue");
int    intValue    = config.getElementAsInt("intValue");
long   longValue   = config.getElementAsLong("longValue");
float  floatValue  = config.getElementAsFloat("floatValue");
double doubleValue = config.getElementAsDouble("doubleValue");
```

And get the values back as a `java.io.File`

```java
File unverifiedFile    = config.getElementAsFile("filePathName");
File verifiedFile      = config.getElementAsVerifiedFile("filePathName");
File verifiedDirectory = config.getElementAsVerifiedDirectory("directoryPathName");
```

### Iterating over elements

Iterate over keys, values, or entry sets

```java
for (String name : config.getNames()) {
    System.out.println("Name: " + name);
}
for (String value : config.getElements()) {
    System.out.println("Value: " + value);
}
for (Map.Entry<String, String> entry : config.getEntries()) {
    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
}
```

## Requirements

* Java 8
* Maven


## Valid configuration file set up

Three basic configuration file styles are accepted by this library:

1. Equals-delimited (`=`)
   ```
  config_element_1 = first_value

  config_element_2 = 200
  ```
2. Colon-delimited (`:`)
  ```
  config_element_1: first_value
  
  config_element_2: 200
  ```
3. White space-delimited
  ```
  config_element_1       first_value
  
  config_element_2       200
  ```
