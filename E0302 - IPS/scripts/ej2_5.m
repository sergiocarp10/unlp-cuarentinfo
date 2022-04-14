%% Limpieza de variables y consola
clear; clc;

%% Carga de la se�al y filtro
load('eeg.mat');
load('ej2_3_filtro.mat');

%% Constantes
Fs = 256;
Ts = 1/Fs;
N = length(x);
D = 1;

%% Aplicaci�n del filtro
y = filter(FIR_BP,x);

%% Energia (inciso 5)
t = (0:Ts*D:Ts*(N-1));
e_y = decimate(y.^2,D);            % con diezmado
z = filter(ones(1,80), 1, e_y);     % filtro de promedio movil de 80 muestras

%% Gr�ficas
figure; plot(t,z); title('Energ�a del EEG filtrado');
xlabel('t [segundos]'); ylabel('z(t)'); xticks((0:5:85)); xlim([0 85]);