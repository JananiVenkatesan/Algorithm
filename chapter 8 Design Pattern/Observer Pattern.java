
When using the Observer pattern, what approaches can be 
used by the subject so that it’s observers can be more 
efficiently updated?

In the Observer pattern, an object can broadcast any changes 
in it’s state to any “observers” – which are basically other 
classes – that want to know about it’s state. Why would an 
“observer” be interested in another object’s state? 

Well, because the state of the object can affect the state of 
the observer – read below for an actual example. So, the object 
being observed is called the “subject”. These observers are 
typically notified when the subject changes because the subject 
will call a method belonging to an observer.

--------------------

Observer Pattern is used in MVC

The Observer pattern plays a key role in the popular MVC – Model 
View Controller – architectural pattern. Any change in state to 
the Model – which represents the underlying data, and is the 
“subject” – will result in a notification to the View, which is 
the Observer.


Now, let’s answer the actual question. One problem that may arise 
with the Observer pattern is that a subject may be updating it’s 
state too frequently. This means that the subject is spending a 
great deal of time updating it’s observers, which is of course 
inefficient. In this scenario, a possible solution is to simply 
have the subject turn off all updates temporarily. Then, the subject 
can make the changes in that period of time. And, once the changes 
are complete, the subject can go ahead and update any and all observers 
with one big notification. This is far more efficient because of the 
fact that only notification is sent out to observers as opposed to 
constantly sending out notifications.

--------------------

Finding a good strategy with the Observer Pattern

One other possible dilemma when dealing with the Observer pattern 
is figuring out a good strategy for observers to know what has been 
changed in the subject. Let’s consider an example website (like Yahoo.com) 
that has to update particular parts of the page (the Observer) when the 
data (the subject) changes. So when a stock price changes, Yahoo will 
have to update the stock portion of the page, and if there’s some breaking 
news, then Yahoo will have to update the “Latest News” portion of the page, etc.

In order for this process to be efficient, the Observer (which is the 
actual webpage) would need to know what data (the subject) has changed – 
whether that data is in the form of a database, XML file, or whatever. 
But, instead of having the page ask the data (or query the data) to find 
out what exactly has changed, it would probably be more efficient to have 
the data (the subject) pass on that information to the webpage. This 
information passed to the webpage from the subject could just be added 
to the normal update notification, and then the webpage can update the 
appropriate portion of the page that needs to change (maybe using AJAX).




