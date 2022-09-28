import numpy as np
from matplotlib import pyplot as plt
import grafica as gr

# lo que recibo en la entrada
X = 0

# lo que deseo en la salida
Y = 1

# W = np.random.uniform(-0.5,0.5, 2)  #[0.7949,  0.3120]
# b = np.random.uniform(-0.5,0.5, 1)  #-2.0388

# pesos y bias iniciales
W = -4
b = -4

# activacion entre 0 y 1
FUN = 'logsig'

# parámetros de aprendizaje
MAX_ITE = 500
alfa = 0.25

ite = 0
E_ant =0
Error = 1
itera = []
while (ite<MAX_ITE): # and (math.fabs(E_ant-Error)>0.000001):
    E_ant = Error
    
    neta = W * X + b

    y = 1.0/(1+np.exp(-neta))
    
    Error = Y - y
    Costo = (Error**2)/2
    derivada = y * (1-y)
    gradiente_W = - Error * derivada * X
    gradiente_b = - Error * derivada
    
    W = W - alfa * gradiente_W
    b = b - alfa * gradiente_b
    
    itera.append([W, b, Costo, y])
    ite = ite + 1
    
itera= np.array(itera)    
x = range(ite)    
fig, axs = plt.subplots(2, 2)
axs[0, 0].plot(x, itera[:,0])
axs[0, 0].set_title('W')
axs[0, 1].plot(x, itera[:,1], 'tab:orange')
axs[0, 1].set_title('b')
axs[1, 0].plot(x, itera[:,2], 'tab:green')
axs[1, 0].set_title('Costo')
axs[1, 1].plot(x, itera[:,3], 'tab:red')
axs[1, 1].set_title('y')
fig.tight_layout()
  







    
