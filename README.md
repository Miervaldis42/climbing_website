# "Les amis de l'escalade" website
>_Project 6 of "Java Software Developer" from OpenClassrooms website_
>_Community website for "Les amis de l'escalade", an association of mountain climbing lovers._

**_Project name_** : mountainClimbingFriends_website

**_Author_** : Alix CAZET

**_Project status_** : On going

**_Project aim_** : Create a website for mountain climbers where they can look for mountains to climb.


## Website URL
[www.lesamisdelescalade.com](http://localhost:8080/lesamisdelescalade/)



## Table of contents
* Databases
    * [MySQL](#setting-up-mysql)
    * [SQL script order](#setting-up-sql-scripts)
* Deployment
    * [Tomcat in Eclipse](#tomcat-in-eclipse)
        * [Tomcat setup](#downlaod-tomcat)
        * [Set up in Eclipse](#installation-in-eclipse)
* Troubleshooting
    * [Tomcat - Change ports](#change-tomcat-ports)


## Databases

### Setting up MySQL
1. Download [MySQL](http://dev.mysql.com/downloads/)
2. Select "MySQL Community Server"
3. Install the software & during the installation, type any password you want for the root user
4. In MySQL software, go to the "localhost - root" to create a new MySQL user
5. Go to File > Run SQL script and select 'create_sqlUser.sql' SQL script
6. To check the SQL user creation, close the "localhost - root" and in the main window of MySQL, click on the "+" to create a new connection
7. In the "New connection setup", do the following in the corrsponding fields:
    * **Connection Name:** Les amis de l'escalade
    * **Username:** admin
8. Click on "Test connection", a pop-up window will appear & ask the password: `lesamisdelescalade`
9. If the connection is successful, close the pop-up window & click on "ok" button.


### Setting up SQL scripts
_All SQL scripts can be found in the project folder in docs > SQLScripts._

* Go into the newly created connection 'Les amis de l'escalade' in MySQL
* Click on File > Run SQL script...

The order to run the SQL scripts are :
1. user_tracker.sql
2. climbingsite_tracker.sql
3. sector_tracker.sql
4. route_tracker.sql
5. length_tracker.sql
6. comment_tracker.sql
7. topo_tracker.sql


## Deployment

### Tomcat in Eclipse

#### Download Tomcat
1. Download [Tomcat](https://tomcat.apache.org/download-90.cgi) files
2. Go to the "Binary distribution" and select a link to donwload Tomcat _(Preferred link is : 32-bit/64-bit Windows Service Installer)_
3. Run the exe file

#### Installation in Eclipse
1. In Eclipse, go to Windows > Preferences > Server > Runtime Environments
2. Click on "Add" button to add a server runtime environment
3. Then, select Tomcat version you installed
4. Leave the default name, select the folder containing Tomcat files, select your jre and hit "Finish" button

5. Back on the Eclipse main window, click on the "No server configured..." hyperlink in the "Server" tab to create a new server / a new instance of Tomcat
6. Leave the all default values and hit the "Finish" button
7. Back on the main window, the new server appears in the "Server" tab. To start it, click once on it and, then on the "Run" button on the far right of the tab
    => The server should be up on running now !


### 'Les amis de l'escalade''s early birds
During your exploration of the website, you can impersonate one of those 3 users :
* _Hal_ : the admin,
* _Sony_ : a member of the association,
* and _Alix_ : a subscriber _(or a 'connected user')_

```
_(user : username, password)_
Hal : admin, admin
Sony : sony@gmail.com, sony
Alix : alix@gmail.com, alix
```


## Troubleshooting

### Change Tomcat ports
1. In Eclipse : In the "Server" tab, double click on the server you create. It will open your Tomcat server parameters in the main window
2. In the 2nd column of Tomcat parameters, there wil be a "Ports" section. In there, you can change the port numbers by clicking on it and tape the new port you want to use
**_N.B:_** The port name used with localhost is HTTPS.


**_DISCLAIMER_**: None of the images or/and icons belong to me, but to their rightful owners.
