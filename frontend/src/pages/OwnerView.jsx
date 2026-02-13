import React, { useEffect, useState } from 'react';
import api from '../api';

export default function OwnerView() {
  const [ownerEmail, setOwnerEmail] = useState('owner@nobroker.local');
  const [list, setList] = useState([]);
  const [form, setForm] = useState({ title: '', city: '', locality: '', rent: 0, bhk: 1 });

  const load = () => api.get(`/properties/owner/${ownerEmail}`).then((res) => setList(res.data));

  useEffect(() => { load(); }, []);

  const submit = async (e) => {
    e.preventDefault();
    await api.post('/properties', { ...form, ownerEmail, rent: Number(form.rent), bhk: Number(form.bhk) });
    setForm({ title: '', city: '', locality: '', rent: 0, bhk: 1 });
    load();
  };

  return (
    <div>
      <h2>Owner View (Post Rental Property)</h2>
      <input value={ownerEmail} onChange={(e) => setOwnerEmail(e.target.value)} />
      <button onClick={load}>Load My Listings</button>
      <form onSubmit={submit} className="form">
        <input placeholder="Title" value={form.title} onChange={(e)=>setForm({...form,title:e.target.value})} required />
        <input placeholder="City" value={form.city} onChange={(e)=>setForm({...form,city:e.target.value})} required />
        <input placeholder="Locality" value={form.locality} onChange={(e)=>setForm({...form,locality:e.target.value})} required />
        <input type="number" placeholder="Rent" value={form.rent} onChange={(e)=>setForm({...form,rent:e.target.value})} required />
        <input type="number" placeholder="BHK" value={form.bhk} onChange={(e)=>setForm({...form,bhk:e.target.value})} required />
        <button type="submit">Post for Moderation</button>
      </form>
      {list.map((p)=><div className="card" key={p.id}>{p.title} | {p.moderationStatus} | Active: {String(p.active)}</div>)}
    </div>
  );
}
