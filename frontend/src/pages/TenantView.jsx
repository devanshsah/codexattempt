import React, { useEffect, useState } from 'react';
import api from '../api';

export default function TenantView() {
  const [properties, setProperties] = useState([]);

  useEffect(() => {
    api.get('/properties/tenant').then((res) => setProperties(res.data));
  }, []);

  return (
    <div>
      <h2>Tenant View (Approved Rentals)</h2>
      {properties.map((p) => (
        <div className="card" key={p.id}>{p.title} | {p.city} | {p.locality} | ₹{p.rent}</div>
      ))}
    </div>
  );
}
