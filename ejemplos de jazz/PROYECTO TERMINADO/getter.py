import re
import sys


     

archivo=open(sys.argv[1],'r+a')
aver=archivo.read()
#print aver
#lee e imprime el archivo
#while linea!="":
 #   print linea
  #  linea=archivo.read()

atributos=re.findall("private ([a-zA-Z]+) ([a-zA-Z]*);",aver)
arreglos=re.findall("private ([a-zA-Z]+) (\[\]+)([a-zA-Z]*);",aver)
print atributos
print arreglos
for i in atributos:
	getter="public "+i[0]+" Get"+i[1]+"(){\n\treturn "+i[1]+"\n}\n"
	setter="public void"+" Set"+i[1]+"("+i[0]+" nuevo){\n\t"+i[1]+"=nuevo\n}\n"
	print getter
	archivo.write(getter)
	print setter
	archivo.write(setter)

for i in arreglos:
	getter="public "+i[0]+" Get"+i[2]+"(int pos){\n\treturn "+i[2]+"[pos]\n}\n"
	setter="public void"+" Set"+i[2]+"(int pos){\n\t"+i[2]+"[pos]=nuevo\n}\n"
	print getter
	archivo.write(getter)
	print setter
	archivo.write(setter)

archivo.close()
