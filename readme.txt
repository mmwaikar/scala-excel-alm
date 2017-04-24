NOTE: This utility works with CSV files, so please convert your *.xlsx file to a *.csv file.

1. Check if java is installed on your system. Open a terminal (cmd prompt) and type
    java -version
   and hit enter. If java is installed, then you'll see an output like java version "1.8.0_101".
   If it is not installed, then you'll see something like "cmd java not found".

2. Install Java from Oracle - https://java.com/en/download/

3. If java is included in the PATH environment variable, then you can run java from any directory (from the cmd prompt).
   If PATH variable is not set, then please append the directory where java is installed to the PATH variable.

4. Unzip the contents of this utility in a directory. You'll see an scala-excel-alm-assembly-0.0.1.jar file that has
   to be run. This utility expects at least one argument -
   -d --dirName (optional) - is the name of the directory where input file is located, and where the output file is to
                             be placed (if you don't provide this argument, then the utility assumes is it to be docs)
   -i --inputFileName (required) - is the name of the input CSV file (that has to be read)
   -o --outputFileName (optional) - is the name of the output CSV file (if you don't provide this argument, then the
                                    utility assumes is it to be output.csv)

5. Run the utility using -
   java -jar scala-excel-alm-assembly-0.0.1.jar -d docs -i DOC-HTMR-9PPGPZ-5.5.csv -o myOutputFileName.csv