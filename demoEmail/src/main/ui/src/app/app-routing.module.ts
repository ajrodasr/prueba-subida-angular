import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistroComponent } from './components/registro/registro.component';
import { IngredienteComponent } from './components/ingrediente/ingrediente.component';
import { IngredientesComponent } from './components/ingredientes/ingredientes.component';
import { IndexComponent } from './components/index/index.component';
import { IngreGuardService } from './guards/ingre-guard.service';
import { LoginGuard } from './guards/login.guard';
import { SendEmailComponent } from './components/send-email/send-email.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';

const routes: Routes = [
  { path: '', component: IndexComponent },
  { path: 'login', component: LoginComponent, canActivate: [LoginGuard] },
  { path: 'registro', component: RegistroComponent, canActivate: [LoginGuard] },
  {
    path: 'send-email',
    component: SendEmailComponent,
    canActivate: [LoginGuard],
  },
  {
    path: 'change-password/:tokenPassword',
    component: ChangePasswordComponent,
    canActivate: [LoginGuard],
  },
  {
    path: 'ingredientes',
    component: IngredientesComponent,
    canActivate: [IngreGuardService],
    data: { expectedRol: ['admin', 'user'] },
  },
  {
    path: 'ingrediente/:id',
    component: IngredienteComponent,
    canActivate: [IngreGuardService],
    data: { expectedRol: ['admin', 'user'] },
  },

  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
