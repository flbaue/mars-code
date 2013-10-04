/* bsp10001.c */
#include <stdio.h>
int main() {
	int x,y;
	printf("\nDies ist ein erstes C-Programm.\n"); 
	printf("\nWie Sie sehen kann 'printf' ");
	printf("nicht nur Texte drucken,\n");
	printf("sondern auch rechnen.\n\n");
	printf("4 + 6 / 2 = %i \n\a",4 + 6 / 2);
	printf("Wert 1 eingeben: ");
	scanf("%i",&x);
	printf("Wert 2 eingeben: ");
	scanf("%i",&y);
	printf("%i + %i = %i\n", x,y,x+y);
	return 0;
}
