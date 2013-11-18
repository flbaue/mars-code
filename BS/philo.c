/*Philosophen problem */
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <semaphore.h>

#define NPHILO 5
#define QUIT 1
#define BLOCK 2
#define UNBLOCK 3
#define PROCEED 4

void *philo(void *arg);
int philoCmd[NPHILO];

int main(void)
{

	/* 1 - inititilaize */

	int result = 0;
	pthread_t tids[NPHILO];

	for (int i = 0; i < NPHILO; ++i)
	{
		result = pthread_create(&tids[i], NULL, philo, NULL);
		if (result != 0) 
		{
			perror("Thread creation failed");
			exit(EXIT_FAILURE);
		}
	}

	

	/* 2 - read comands in loop*/

	string input = "";
	while(!(strcmp(input, "q") || strcmp(input, "Q"))) /* TODO while philos exist */ 
	{
		result = fgets(*input);
		if(result != 0) 
		{
			perror("Read console failed");
			exit(EXIT_FAILURE);
		}

		/* quit all */
		if(strcmp(input, "q") || strcmp(input, "Q")) 
		{
			for (int i = 0; i < NPHILO; ++i)
			{
				philoCmd[i] = QUIT;
			}
		} 
		else
		{ 
			char cmd = strchr(input,strlen(input) - 1)
			int philNum = 0; /* TODO number from input */

			if(cmd == 'b') 
			{
				philoCmd[philNum] = BLOCK;
			}

			if(cmd == 'u') 
			{
				philoCmd[philNum] = UNBLOCK;
			}

			if(cmd == 'p') 
			{
				philoCmd[philNum] = PROCEED;
			}
		}
	}


	/* 3 - exit on quit comand */

	return 0;
}

int philo(void)
{
	/* code */
	return 0;
}