# PollView

    ##Introduction

      Android custom view to show Polls for MCQ. You can add any number of options and customise the Styles of views 

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
	  
To apply styles to question textview

           use pollview.questionTextView
To apply styles to options

            use pollview.optionViews.forEach
	    {
	      it.tvOption               //textview
              it.tvPercent              //textview
              it.seekBar                // seekbar
	    }
	    
To change the progress color you have to provide two drawable 

             setDefaultProgressDrawable(drawable: Drawable)            
             setSelectedProgressDrawable(drawable: Drawable)
      
      Note:Drawable will be similar to
     [] https://github.com/shivamvns19111999/PollView/blob/master/PollViewLibrary/src/main/res/drawable /progress_track.xml
  

To get the selected option 

                pass the OnClickOptionListener to PollView using 
                setOnOptionCLickListener(onOptionClickListener: OnOptionClickListener)
		

To get the updated vote counts for options use 

                                       pollview.getVoteCount():ArrayList<Int>
				       


![](https://github.com/shivamvns19111999/PollView/blob/master/ezgif.com-gif-maker(1).gif)
