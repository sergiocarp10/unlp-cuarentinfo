%% Limpieza de variables y consola
clear; clc;

%% Carga de la se�al desde su archivo
load('eeg.mat');

%% Constantes
Fs = 256;
Ts = 1/Fs;
N = length(x);

%% Soporte
t = (0:Ts:Ts*(N-1));

%% Visualizaci�n de la se�al
plot(t,x); title('Electroencefalograma (EEG)'); 
xlabel('t [segundos]'); ylabel('x(t)'); xticks((0:5:85)); xlim([0 85]);