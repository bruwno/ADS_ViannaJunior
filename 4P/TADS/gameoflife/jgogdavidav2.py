import numpy as np
import matplotlib.pyplot as fig
from matplotlib import animation
import random

def update(data):
    global a
    global count

    nova_a = np.zeros((n+1,n+1))
    for i in range(1,n):
        for j in range(1,n):
            vizinho = 0

            if a[i-1,j-1]==1:
                    vizinho=vizinho+1                       
            if a[i,j-1]==1:
                    vizinho=vizinho+1                          
            if a[i+1,j-1]==1:
                    vizinho=vizinho+1                       
            if a[i+1,j]==1:
                    vizinho=vizinho+1                       
            if a[i+1,j+1]==1:
                    vizinho=vizinho+1                       
            if a[i,j+1]==1:
                    vizinho=vizinho+1                       
            if a[i-1,j+1]==1:
                    vizinho=vizinho+1                      
            if a[i-1,j]==1:
                    vizinho=vizinho+1
            # REGRAS                          
            if a[i,j]==1:
                if (vizinho==2) or (vizinho==3):
                       novo_a[i,j]=1
                else:
                       novo_a[i,j]=0
            else:
                if vizinho==3:
                      novo_a[i,j]=1              
                else:
                      novo_a[i,j]=0            
                              
    a = nova_a
    im.set_data(a)
    s = 0
    for i in range(n):
          for j in range(n):
                s += a[i,j]
    count += 1
    vivo[count] = s
    fig.figure(2)
    fig.title("GERAÇÃO %d" % count, fontsize=20)
    fig.plot(vivo[:count], "-k")
    fig.xlabel("GERAÇÃO", fontsize=12)
    fig.ylabel("POPULAÇÃO", fontsize=12)
    mgr = fig.get_current_fig_manager()
    mgr.window.setGeometry = (800,20,1000,500)
    fig.pause(0.3)
    return im

n = 80