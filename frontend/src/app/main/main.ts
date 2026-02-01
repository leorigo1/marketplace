import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductService } from '../services/ProductService';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [ CommonModule ],
  templateUrl: './main.html',
  styleUrl: './main.scss',
})
export class Main {

products: any[] = [];

  constructor(private service: ProductService) {}

  ngOnInit(): void {

    this.service.getAllProducts().subscribe({
      next: (data) => {
         this.products = data;
         console.log(data)
      },
      error: (err) => {
        console.log("Erro: " + err)
      }
    })
  }


}
