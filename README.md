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
      
      pollView.setQuestion(String:Question) 

set option using 

          pollView.setOptions(ArrayList String :option,ArrayList String :voteCountForEachOption)
  


file:///home/this/Downloads/ezgif.com-gif-maker.gif![image](https://user-images.githubusercontent.com/54793097/161969782-b08dc16f-4466-4797-bae9-f8e69d53dae0.png)
