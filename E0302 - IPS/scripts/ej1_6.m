%% Limpiamos variables y figuras anteriores
clear
clc

%% Declaraci�n de constantes
T = 1023;             % �ltimo indice del primer periodo de se�al
SAT = [2 8 16];       % N�meros de sat�lites

%% Cargamos la se�al inc�gnita (s)
load('senial_incognita.mat');

%% Tomamos 1 periodo de la se�al y agregamos ruido
xinc = s(1:T);
xincn = xinc+7*randn(size(xinc));

%% Graficamos ambas se�ales
subplot(2,1,1); stem(xinc,'.'); title('Se�al inc�gnita');
xlabel('n'); ylabel('xinc[n]'); xticks((0:128:1024)); axis([0 1024 -25 25]);

subplot(2,1,2); stem(xincn,'.'); title('Se�al inc�gnita con ruido adicionado');
xlabel('n'); ylabel('xincn[n]'); xticks((0:128:1024)); axis([0 1024 -25 25]);

%% Comparamos la se�al con ruido con la correspondiente a cada sat�lite
m = (-511:1:511);

for k = 1 : length(SAT)
    % Generaci�n del c�digo de sat�lite
    x = cacode(SAT(k));
    % C�lculo de la intercorrelaci�n con la se�al inc�gnita
    r = correlfft(x, xincn);
    % Se genera la imagen del resultado para el sat�lite actual
    figure; stem(m,fftshift(r),'.'); title(strcat('Intercorrelaci�n para Sat�lite:',num2str(SAT(k))));
    xlabel('m'); ylabel('r�_x_s[m]');
end