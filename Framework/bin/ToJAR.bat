mkdir java
rm Framework.jar
cp -r */*.java java
rm -r class
mkdir class
javac -d class java/*.java
rm -r java
cd class 
rm Framework.jar
jar -cvf Framework.jar *
mv Framework.jar ../
cd ..
rm -r class