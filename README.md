# HARDWARE DIDACTIC GALACTIC MEETUP

## Reverse Engineering Design File Formats
 
### Compiling and running

Clone repository and then run following:

    mvn install compile package
    java -jar target/final-altium-schematic-importer-1.0.jar -c <path/to/your/file.SchDoc>
    
This produces output similar to: 

  Successful!
  ```json
  {
    "RECORD": "31",
    "CUSTOMY": "950",
    "children": [
      {
        "RECORD": "41",
        "NAME": "ConfigurationParameters",
        "TEXT": "*",
        "ISHIDDEN": "T",
        "READONLYSTATE": "1",
        "COLOR": "8388608",
        "OWNERPARTID": "-1",
        "FONTID": "1",
        "UNIQUEID": "QTURANBL"
      },
      {
        "Y3": "220",
        "Y4": "220",
        "X1": "1210",
        "Y1": "340",
        "X2": "1140",
        "RECORD": "6",
        "Y2": "340",
        "X3": "1140",
        "X4": "1210",
        "X5": "1210",
        "Y5": "340",
        "LINEWIDTH": "1",
        "LINESTYLE": "1",
        "OWNERPARTID": "-1",
        "LOCATIONCOUNT": "5",
        "COLOR": "16711680"
      },
      {
        "Y3": "980",
        "Y4": "980",
        "X1": "1240",
        "Y1": "1060",
        "X2": "1180",
        "RECORD": "6",
        "Y2": "1060",
        "X3": "1180",
        "X4": "1240",
        "X5": "1240",
        "Y5": "1060",
        "LINEWIDTH": "1",
        "LINESTYLE": "1",
        "OWNERPARTID": "-1",
        "LOCATIONCOUNT": "5",
        "COLOR": "16711680"
      },
      {
        "Y3": "750",
        "LOCATIONCOUNT": "4",
   .....
  }
  ```