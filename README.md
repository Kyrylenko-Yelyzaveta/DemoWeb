# DemoWeb
Double request application

## Main task
Develop an android application that:
When launched, it makes a request to

`http://demo3005513.mockable.io/api/v1/entities/getAllIds`

and gets a list of entries with the identifiers of these entries (we will call it A);
Selects the first record from the server response and makes a request (B) to 

`http://demo3005513.mockable.io/api/v1/object/<record ID>` 

and further depending on the value of the type attribute:
 - type=text: the application displays a screen with the text from the message attribute of the response to request B;
 - type=webview: the application displays a screen with a WebView in which the URL from the url attribute of the response to request B is opened;
 - type=image: the application displays a screen with the image from the url attribute of the response to request B;
 - type=game ignore.
There is a "next" on the screen, clicking on which causes the application to display the next object from A. If the application is already displaying the last object from A, then pressing this button should return it to the first object in the list.
Application screen example:


 

## Highlight
		
![]([ezgif.com-gif-maker.gif](https://github.com/Kyrylenko-Yelyzaveta/DemoWeb/blob/master/ezgif.com-gif-maker.gif))
		

