# PollView

    ##Introduction

      Android custom view to show Polls for MCQ.

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.shivamvns19111999:PollView:1.0.0'
	}
  
  To use it enable view binding in your project
 then use as a view in XML 
 
         <com.shivam.pollview.PollView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

Set question using 
      
      pollView.setQuestion(String:Question) 

set option using 

          pollView.setOptions(ArrayList String :option,ArrayList String :voteCountForEachOption)
  


![](https://github.com/shivamvns19111999/PollView/blob/master/ezgif.com-gif-maker(1).gif)
