# PollView



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
	        implementation 'com.github.shivamvns19111999:PollView:PollView'
	}
  
  To use it enable view binding in your project
 then use as a view in XML 
 
  <com.shivam.pollview.PollView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

Set question using 
setQuestion function 

set option using 
pollView.setOptions(Array<String>:option,ArrayList<Int>  voteCountForEachOption)
  



