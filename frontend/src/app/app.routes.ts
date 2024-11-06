import { Routes } from '@angular/router';
import { RoomComponent } from './room/room.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    {path: 'room', component: RoomComponent},
    {path: 'home', component: HomeComponent},
];
