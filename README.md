# "Les amis de l'escalade" website
>_Project 6 of "Java Software Developer" from OpenClassrooms website_
>_Community website for "Les amis de l'escalade", an association of mountain climbing lovers._

**_Project name_** : mountainClimbingFriends_website

**_Author_** : Alix CAZET

**_Project status_** : On going

**_Project aim_** :
Create a website for mountain climbers where they can look for mountains to climb.


# Deployment

## Tomcat in Eclipse

### Download Tomcat
1. Download [Tomcat](https://tomcat.apache.org/download-90.cgi) files
2. Go to the "Binary distribution" and select a link to donwload Tomcat (Preferred link is : 32-bit/64-bit Windows Service Installer)
3. Run the exe file

### Install it in Eclipse
1. In Eclipse, go to Windows > Preferences > Server > Runtime Environments
2. Click on "Add" button to add a server runtime environment
3. Then, select Tomcat version you install
4. Leave the default name, select the folder containing Tomcat files, select your jre and hit "Finish" button

5. Back on the Eclipse main window, click on the "No server configured..." hyperlink in the "Server" tab to create a new server / a new instance of Tomcat
6. Leave the all default values and hit the "Finish" button
7. Back on the main window, the new server appears in the "Server" tab. To start it, click once on it and, then on the "Run" button on the far right of the tab


# Troubleshooting

## Tomcat

### Change Tomcat ports
1. Go to Eclipse, then, in the "Server" tab, double click on the server you create. It will open your Tomcat server parameters in the main window
2. In the 2nd column of Tomcat parameters, there wil be a "Ports" section. In there, you can change the port numbers by clicking on it and tape the new port you want to use