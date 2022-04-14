%% Limpieza de variables y consola;
clear; clc;

%% Declaraci�n de constantes
SAT = (1:1:32);       % N�meros de sat�lites
T = 1023;             % �ltimo indice del primer periodo de se�al

%% Carga de la se�al inc�gnita (s) y extracci�n de 1 per�odo
load('senial_incognita.mat');
xinc = s(1:T);

%% Comparamos la se�al con la correspondiente a cada sat�lite
m = (-511:1:511);

for k = 1 : length(SAT)
    x = cacode(SAT(k));                 % C�digo Gold de sat�lite
    r = correlfft(x, xinc);             % Intercorrelaci�n
    figure; stem(m,fftshift(r),'.');   
    title(strcat('Intercorrelaci�n para Sat�lite:',num2str(SAT(k))));
    xlabel('m'); ylabel('r�_x_s[m]');
end
