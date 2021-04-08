# FIRST-COME-FIRST-SERVE CPU SCHEDULING ALGORITHM
___

In this technique, first job claims the first available memory with space more than or equal to it’s size. The operating system doesn’t search for appropriate partition but just allocate the job to the nearest memory partition available with sufficient size.

### HOW IT WORKS

This program accept the following as inputs

* Number of processes
* Burst Time for every process

#### After accepting the input it then compute the following


#### * Waiting Time

Which is Previous waiting time + Previous burst time

#### * Turnaround Time

Which is Previous turnaround time + Burst time

#### * Average Turnaround 

Which is total of burst time / number of processes

#### After the computation, the program then display the following

* Process Number(in order of execution)
* Every Process Burst Time
* Every Process Waiting Time
* Every Process Turnaround Time
* Average Burst Time
* Average Turnaround Time


### RUN CODE
To run the this program. You should copy the entire contents of the folder into a project in the IDE or Text Editor, and then run the Main.java in the folder.

