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
String configValue = config.getString("configValueName");
```

Even parse the values into any primitive value

```java
boolean boolValue   = config.getBoolean("boolName");
byte    byteValue   = config.getByte("byteName");
char    charValue   = config.getChar("charName");
short   shortValue  = config.getShort("shortName");
int     intValue    = config.getInt("intName");
long    longValue   = config.getLong("longName");
float   floatValue  = config.getFloat("floatName");
double  doubleValue = config.getDouble("doubleName");
```

And get the values back as a `java.io.File`

```java
File unverifiedFile    = config.getFile("filePathName");
File verifiedFile      = config.getVerifiedFile("filePathName");
File verifiedDirectory = config.getVerifiedDirectory("directoryPathName");
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


## Example

### Config file set up

File name: `/Users/Zach/Documents/configFile.properties`

`configFile.properties` contents: 

```
myInteger          11
myChar             Z
myFile             /Users/Zach/Documents/file.txt
myDirectory        /Users/Zach/Documents/my_dir
```

### Parsing file

```java
// Parse configuration file
Config config = new Config("/Users/Zach/Documents/configFile.properties");
```

### Accessing elements

```java
// Access elements by name
int  someInt  = config.getInteger("myInteger");
char someChar = config.getChar("myChar");
File myFile   = config.getVerifiedFile("myFile");
File myDir    = config.getVerifiedDirectory("myDirectory");

// Iterating over each element value
for (String element : config.getElements() {
    System.out.println("Element: " + element);
}
// This will print:
// Element: 11
// Element: Z
// Element: /Users/Zach/Documents/file.txt
// Element: /Users/Zach/Documents/my_dir

// Iterating over each element name
for (String name : config.getNames() {
    System.out.println("Name: " + name);
}
// This will print:
// Name: myInteger
// Name: myChar
// Name: myFile
// Name: myDirectory
```

## Requirements

* Java 8
* Maven 3
