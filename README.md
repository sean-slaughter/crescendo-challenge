# crescendo-challenge
Code challenge for Crescendo Collective using Yelp Fusion API and Google Vision API

<h1>Hi, My name is Sean Thompson and I would love to work with your team as a Back End Developer!</h1>

# To Run
To run this program: <br>
1. Clone this repository and cd into the project folder.<br>
2. Make sure you have Maven installed on your local machine.<br>
3. Put the Yelp API credentials into the file 'src/main/resources/yelp.properties'.<br>
4. Put the Google Vision API credientials into the directory 'src/main/resources/'.<br>
5. Add the following line to application.properties file 'spring.cloud.gcp.credentials.location=file:src/main/resources/<GOOGLE_CREDENTIALS_FILENAME>'<br>
6. Run the program with the command './mvnw spring-boot:run'<br>

Thanks for the challenge, I had a lot of fun with this one!

Note: I thought that the yelp.properties file and google credentials JSON file were both being ignored by git.ignore, looks like I made a mistake but I went and deleted these API keys from my accounts, just for the record!
