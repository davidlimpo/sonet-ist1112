# version 2.1
ARGS="Rede Social com objectos"
PROJ=sonet
FILES= README Makefile MANIFEST.MF data.txt
I=-DImport=data.txt # run without importing: make I=
all:
	javac `find $(PROJ) pt -name "*.java"`
	jar -cfm $(PROJ)-`date "+%Y%m%d%H%M%S"`.jar MANIFEST.MF `find $(PROJ) pt -name "*.java"` $(FILES)
	jar -cf pt.jar `find pt -name "*.class"`
	jar -cfm $(PROJ).jar MANIFEST.MF pt.jar `find $(PROJ) -name "*.class"`
run:
	java $(I) -jar $(PROJ).jar $(ARGS)

swing:
	java $(I) -Dui=swing -jar $(PROJ).jar $(ARGS)
clean:
	rm -f `find $(PROJ) pt -name "*.class"`
