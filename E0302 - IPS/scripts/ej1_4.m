%% Limpieza de variables y consola;
clear; clc;

%% Declaraci�n de constantes
K = 200;                % Lugares a desplazar hacia la derecha

%% Generaci�n de las se�ales
x = cacode(14);         % Se�al generada del Sat�lite 14
y = circshift(x,K);     % Se�al desplazada del Sat�lite 14

%% Soporte
m = (-511:1:511);

%% Intercorrelaci�n
r_yx = correlfft(y,x);
figure; stem(m, fftshift(r_yx), '.'); 
title('Intercorrelaci�n de la se�al de Sat�lite 14 y su versi�n desplazada');
xlabel('m'); ylabel('r�_y_x[m]');