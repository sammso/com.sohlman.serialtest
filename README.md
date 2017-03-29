# Some tests of serialization

Note the app is not polished.

To compile

```
mvn package
```

Run:

### Serialize object with no serialVersionUID

```
java -jar com.sohlman.serialtest-0.0.1-SNAPSHOT.jar write noid NoIdPerson.ser My Name
```

### Serialize object with serialVersionUID

```
java -jar com.sohlman.serialtest-0.0.1-SNAPSHOT.jar write id IdPerson.ser My Name
```

### Deseriazile object and print the value

```
java -jar com.sohlman.serialtest-0.0.1-SNAPSHOT.jar read NoIdPerson.ser
```


