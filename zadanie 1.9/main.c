#include <stdio.h>
#define NMAX 32000

int main(void){
int n,i,j,k,p;
double a,b;
printf("Podaj n: ");
scanf("%i", &n);
do {
  printf("Podaj a i b z zalozeniem a<b\na: ");
  scanf("%lf", &a);
  printf("b: ");
  scanf("%lf", &b);
} while (a>=b || a>NMAX || b>NMAX);
double h = (b-a)/n;
double x[n+1];
for (i=0; i<=n; i++){
  x[i] = a + i * h;
  printf("x[%i] = %lf\n", i, x[i]);
}
double l[n+1][n+1];
for (i=0; i<=n; i++){
  for (j=1; j<=n; j++){
    l[i][j] = 0;
  }
  l[i][0] = 1;
}
for (i=0; i<=n; i++){
  for (k=0; k<=n; k++){
    if (i!=k){
      for (p=n; p>0; p--){
        l[i][p] = l[i][p-1];
      }
      for (p=n-1; p>=0; p--){
        l[i][p] -= x[k] * l[i][p+1];
      }
      for (p=0; p<=n; p++){
        l[i][p] /= x[i] - x[k];
      }
    }
  }
}

for (i=0; i<=n; i++){
  for (j=n; j>=0; j--){
    printf("%lf ", l[i][j]);
  }
  printf("\n");
}

return 0;
}
