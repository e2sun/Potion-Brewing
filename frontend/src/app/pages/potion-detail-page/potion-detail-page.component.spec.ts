import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PotionDetailPageComponent } from './potion-detail-page.component';

describe('PotionDetailPageComponent', () => {
  let component: PotionDetailPageComponent;
  let fixture: ComponentFixture<PotionDetailPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PotionDetailPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PotionDetailPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
