# stopwatchapp-ToastyKrabstix

Activities are the foundation of every Android application. This assignment illustrates the fundamental activity life cycle.

## Pre-requisite:

Activity Lifecycle Introduction Assignment (with Logcat output):

https://github.com/DeLaSalleUniversity-Manila/activitylifecycleintroduction-melvincabatuan 


## Problem:

Design and implement an Android Stopwatch application. The app should be able to handle configuration changes like screen rotation. (Refer to Chapter 4 of Head First Android Development by Dawn Griffiths and David Griffiths for more details.)    

https://github.com/DeLaSalleUniversity-Manila/HeadFirstAndroid 



## Keypoints:

In the MainActivity.java, the basic Button methods are:

```Java
  //Start the stopwatch running when the Start button is clicked.
    public void onClickStart(View view) {
        isRunning = true;
    }

    //Stop the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view) {
        isRunning = false;
    }

    //Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view) {
        isRunning = false;
        seconds = 0;
    }
```


In the MainActivity.java, the basic life cycle handling are:
```Java
    // The activity is now visible (but not ready for user interaction)
    @Override
    protected void onStart() {
        super.onStart();
        isRunning = wasRunning;
    }

    // The activity is now in the foreground and ready for user interaction
    @Override
    protected void onResume() {
        super.onResume();
        isRunning = wasRunning;
    }
    
    // Counterpart to onResume(). The activity is about to go into the background and has stopped interacting with the user. 
    // This can happen when another activity is launched in front of the current activity.
       @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    // Counterpart to onStart(). The activity is no longer visible to the user.
    @Override
    protected void onStop() {
        super.onStop();
        wasRunning = isRunning;
        isRunning = false;
    }
    
    // Handle configuration changes by saving the Activity state variables
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("isRunning", isRunning);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }
```


## Screenshots:

![alt tag](https://github.com/DeLaSalleUniversity-Manila/stopwatchapp-ToastyKrabstix/blob/master/device-2015-10-05-193011.png)

![alt tag](https://github.com/DeLaSalleUniversity-Manila/stopwatchapp-ToastyKrabstix/blob/master/device-2015-10-05-193023.png)

![alt tag](https://github.com/DeLaSalleUniversity-Manila/stopwatchapp-ToastyKrabstix/blob/master/device-2015-10-05-193037.png)
