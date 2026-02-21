import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PotionDetailComponent } from './potion-detail.component';

describe('PotionDetailComponent', () => {
  let component: PotionDetailComponent;
  let fixture: ComponentFixture<PotionDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PotionDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PotionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
