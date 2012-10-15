#include <stdio.h>
#define NMAX 32000

int main(void){
int n,i,j,k,p;
double a,b;
do {
  printf("Podaj n: ");
  scanf("%i", &n);
} while (n>NMAX);
do {
  printf("Podaj a i b z zalozeniem a<b\na: ");
  scanf("%lf", &a);
  printf("b: ");
  scanf("%lf", &b);
} while (a>=b);
double h = (b-a)/n;
double x[n+1];
for (i=0; i<=n; i++){
  x[i] = a + i * h;
//  printf("x[%i] = %lf\n", i, x[i]);
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
      l[i][0] = 0;
      for (p=0; p<=n-1; p++){
        l[i][p] -= x[k] * l[i][p+1];
      }
      for (p=0; p<=n; p++){
        l[i][p] /= x[i] - x[k];
      }
    }
  }
}

/* wyswietlanie l[][]
for (i=0; i<=n; i++){
  printf("l[%i]: ", i);
  for (j=n; j>=0; j--){
    printf("%.3lfx^%i ", l[i][j],j);
  }
  printf("\n");
}*/

double c[n+1], w[n+1];
char o;

wczytaj:
for (i=0; i<=n; i++){
  printf("Podaj A[%i]: ", i);
  scanf("%lf", &c[i]);
}

for (i=0; i<=n; i++){
  w[i] = 0;
}

for (i=0; i<=n; i++){
  for (j=0; j<=n; j++){
    w[j] += ( c[i] * l[i][j] );
  }
}

for (i=n; i>=0; i--){
  printf("%.3lfx^%i ", w[i], i);
}

printf("\nWprowadzac dane ponownie? (t/n) ");
do {
  scanf("%c", &o);
} while (o!='t' && o!='n');

if (o=='t'){
  goto wczytaj;
}

putchar('\n');
return 0;
}
