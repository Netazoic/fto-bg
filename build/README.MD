#MDS Portal Build Notes


Ivy management happens in two parts:  1) jars for Tomcat  and 2) jars for Eclipse

##1.  Jars in the /lib directory -- used by Tomcat at runtime

	build_MDS.xml  
			Ant build file.  Use the "retrieve" target to retrive assets using ivy
			
			
##2. Jars in the Eclipse build path, used for compiling during development.  

You *could* just reference all the libraries in the lib directory, as per our old standard practice.  Or you could get with the times and
			
Add ivy controlled libraries to the build path:

	Select Configure Build Path
	Add Library
	Select IvyDE Managed libraries
	Specify build/ivy.xml as the ivy file

That way, whenever you change the ivy.xml file, the list of referenced libraries updates automatically.  (You then do need to circle back to step 1 to retrieve the latest set to /lib.)



##Unfortunately

Because there are (currently) about 10 libraries that cannot be resolved through ivy, you also have to manually reference the jars in the folder build/no-ivy.  Select these jars, right-click, select build-path, add to build path.	