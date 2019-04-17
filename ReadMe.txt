1. When you run your app and rotate the device/emulator compare the method counts in the
shared preferences with methods called in the log and with the method counts passed to
the activity in the bundle.

Ans: After changing the orientation we observe the method count as mentioned below


			onCreate onStart onResume onPause onRestart onStop onDestroy onSaveInstance onRestoreInstance
Shared Preference	    1       1        1       2        0       1        0           1             0
(Portrait)

Shared Preference	    2       2        2       3        0       2        1           2             1
(Landscape)

Bundle	                    1       1        1       2        0       1        0           2             0