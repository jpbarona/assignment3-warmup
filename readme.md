# Assignment 3 Warmup: Read Me First


This project consists of the warmup exercises for Assignment 3 ("Assignment 3 Warmup").

It consists of six exercises that ask you to apply different pieces of knowledge that you have gained throughout the 
course so far.  The goal of the warmup is to ensure that whatever your background, you have an opportunity to work through
developing a basic program solving a simple form of the assessment problem, where you can ask for help if you need it,
prior to the assessed stage where you are required to work individually.

The full assignment 3 (Assignment 3 Full) will build on these instructions and requirements, so it is 
recommended to start working on the warmup as soon as it is available, but not required.

However, if you are not already an expert Java programmer, this warmup is intended to help ensure you are prepared for 
the assessment, ideally with a partial solution that can be modified to meet new requirements you will be given.

**Since the warmup itself is not assessed, you are free to work together on it, ask your favorite chatbot, etc.  
However, this is not the case for the assessed stage of assignment 3, so it is essential that whatever you do during the 
warmup, you understand well enough to adapt in the assessed stage WITHOUT assistance.**

The task in the warmup is to implement a simplified version of EVE: the EVE Vehicle Estimator (yet another recursive
acronym that is irritatingly common in programming).  EVE version 1.0 reads in specifications of vehicles that
are to be ordered, checks that they are valid (make sense as vehicles) and calculates their cost.  The output consists 
of the information from the input which has been reformatted to a consistent form and augmented with the validity and 
cost information.  

The exercises that outline the main requirements and suggested steps for meeting them are provided as markdown files 
like this:

* `ex01_input.md`: defines the input format and standardisation rules
* `ex02_structure.md`: defines how some field values can have structure, e.g. comma separated lists, and how they are 
  to be treated and standardised.
* `ex03_output.md`: describes how to augment the input data with the required output fields, initially with dummy values.
* `ex04_validation.md`: describes the validation rules and how validity information is to be added to the output.
* `ex05_cost.md`: describes the cost rules and how cost information is to be added to the output.
* `ex06_design.md`: suggests that once the coding exercises 1-5 are complete, you spend some time reflecting on the 
  code, and any design decisions, and documenting the design and/or code. 

There is also a `src/` directory containing a dummy `EVEMain.java` file.  It is suggested that you keep this file and use its 
main method as the entry point to your solution to the warmup: you do not have to do this (we aren't going to check at this point) 
but if you do, then adapting your warmup solution for use in the Assignment 3 assessment should be easier.  It is 
perfectly fine to also support other modes of execution, for example to read from a file if a filename is provided
as a command-line argument.

You may add any Java files you want to the `src/` directory.  For assignment 3 assessment submissions, we are going to 
ask that all Java files be immediately in the `src` subdirectory and not organised further into packages/subdirectories.  
So you may want to avoid doing that now, to avoid having to reorganise things later.  It isn't particularly good software 
engineering practice, but makes the automatic grading of the assessment easier. 

Similarly, please do not base your solution on any external libraries beyond the Java standard libraries included with 
Java 17.  While there are no consequences for doing this at this stage, in the assessed stage of Assignment 3 your code will
be compiled without any external libraries, so if you do this, your submission will be very unlikely to work.


Some general observations/principles you might wish to follow are:

* Go from working to working.  Each exercise outlines a small piece of functionality that you can implement and test, 
  before considering other perhaps more complex features.  Make sure that your system works as solution to exercise 1..n 
  before moving on to n+1.
* Test as you go.  The exercises include a running example that tests some of the functionality, but writing other 
  tests that consider corner cases is a good idea.  
* Document / design as you go.  The sixth exercise encourages you to reflect on the design and document the code and 
  design at the end of the coding exercises.  But you can also do this incrementally, as you solve each exercise.  If 
  you do so then update your notes to reflect the final design should be easy.
* Version control and/or regular backups are a very, very good idea.