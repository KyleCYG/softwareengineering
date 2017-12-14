OUTPUT=../../../target/pdf
TMP=$OUTPUT/tmp
rm -rf $OUTPUT
mkdir -p $OUTPUT
mkdir $TMP
find ../../../src/main/java -iname "*.java" -type f -exec ./makepdf.sh {} $TMP \;
find ../../../src/test/java -iname "*.java" -type f -exec ./makepdf.sh {} $TMP \;
pdfjoin $TMP/*.pdf --outfile $OUTPUT/code.pdf
rm -rf $TMP
