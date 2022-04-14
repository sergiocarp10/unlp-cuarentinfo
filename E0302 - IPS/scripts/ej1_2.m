%% Limpieza de variables y consola
clear; clc;

%% Generaci�n de se�ales
x = cacode(12);             % C�digo Gold correspondiente al sat�lite 12
y = randi([0,1],size(x));   % Se�al de ruido (valores 0 y 1)
y(y==0) = -1;               % "y" toma 2 valores posibles: -1 y 1

%% C�lculo de correlaciones
r_xx = correlfft(x,x);      % Autocorrelaci�n de "x"
r_yy = correlfft(y,y);      % Autocorrelaci�n de "y"
r_xy = correlfft(x,y);      % Intercorrelaci�n de "x" e "y"

%% Soportes (eje de abscisas)
n = (0:1:length(x)-1);
m = (-511:1:511);

%% Visualizaci�n de las se�ales
figure; subplot(2,1,1); stem(n,x,'.'); xticks((0:128:1024)); xlim([0 1024]);
title('Se�al tipo c�digo Gold del Sat�lite 12'); xlabel('n'); ylabel('x[n]');

subplot(2,1,2); stem(n,y,'.'); xticks((0:128:1024)); xlim([0 1024]);
title('Se�al de ruido'); xlabel('n'); ylabel('y[n]');

%% Visualizaci�n de autocorrelaciones
figure; subplot(2,1,1); stem(m,fftshift(r_xx),'.'); xticks((-512:128:512)); xlim([-512 512]);
title('Autocorrelaci�n de x'); xlabel('m'); ylabel('r�_x_x[m]');

subplot(2,1,2); stem(m,fftshift(r_yy),'.'); xticks((-512:128:512)); xlim([-512 512]);
title('Autocorrelaci�n de y'); xlabel('m'); ylabel('r�_y_y[m]');

%% Visualizaci�n de la intercorrelaci�n
figure; stem(m,fftshift(r_xy),'.'); xticks((-512:128:512)); xlim([-512 512]);
title('Intercorrelaci�n de x e y'); xlabel('m'); ylabel('r�_x_y[m]');
